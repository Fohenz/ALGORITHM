package main

import (
  "fmt"
  "math"
)

func main(){
  //카드 비싸게 구매하기
  var N, tmp int
  var arr [1001]int

  fmt.Scan(&N)
  for i:=1; i<=N; i++{
    fmt.Scanf("%d",&tmp)
    max := tmp
    for j:=1; j <= i; j++{
      max = int(math.Max(float64(max), float64(arr[j] + arr[i-j])))
    }
    arr[i] = max
  }
  fmt.Println(arr[N])
}
