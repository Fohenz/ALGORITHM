package main

import "fmt"

func main(){
  //1, 2, 3으로 숫자 만들기
  var T, n int
  var arr [11]int
  fmt.Scan(&T)
  for i:=0; i<T; i++{
    fmt.Scan(&n)
    arr[0] = 1
    arr[1] = 1
    arr[2] = 2
    for j:=3; j <= n; j++{
      arr[j] = arr[j-1] + arr[j-2] + arr[j-3]
    }
    fmt.Println(arr[n])
  }
}
