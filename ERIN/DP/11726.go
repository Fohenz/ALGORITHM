package main

import(
  "fmt"
)

func main(){
  //2*n 타일만들기
  var input int
  var arr [1001]int
  fmt.Scan(&input)
  arr[0] = 1
  arr[1] = 1
  for i:=2; i<=input; i++{
    arr[i] = (arr[i-1] + arr[i-2])% 10007
  }
  fmt.Println(arr[input])
}
