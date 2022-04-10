# simple-distributed-lock

이 예제에서는 많은 부분을 축약했습니다.

> 첫째로 주문을 할때 상품의 재고를 전혀 고려하지 않았습니다. 

상품의 재고가 1개 남았을 때, 유저 2명이 동시에 주문한다면 재고가 -1이 되는 현상이 발생될 수 있습니다.

이런경우에는 상품의 재고에도 관리를 해주어야하며, 이럴때는 lock 획득 실패시 실패처리를 하는것이 아니라 잡혀있는 lock 이 끝나면 lock 획득시도를 다시 하는 로직이 추가되어야 합니다.

> 둘째로 redis 의 클러스가 1대만 있다고 가정했습니다.

이때는 redis 가 single points of failure 가 될 수 있습니다.

이런 문제점을 어떻게 처리할지 고려가 되어야합니다.
