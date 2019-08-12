package main

import (
  "fmt"
  "math"
)

func main(){
  //3으로 나누거나, 2로 나누거나, 1을 빼서 숫자 만들기
  var arr [1000001]int
  var input int
  var tmp1, tmp2 float64
  fmt.Scan(&input)
  arr[0] = 1
  arr[1] = 0
  for i:=2; i<=input; i++{
    if i%3 == 0 {
      tmp1 = math.Min(float64(arr[i/3]), float64(arr[i-1]))
    }else{
      tmp1 = float64(arr[i-1])
    }
    if i%2 == 0{
      tmp2 = math.Min(float64(arr[i/2]), float64(arr[i-1]))
    }else{
      tmp2 = float64(arr[i-1])
    }
    arr[i] = int(math.Min(tmp1, tmp2)) + 1
  }

  fmt.Println(arr[input])
}
