package main

import (
  "fmt"
)

func main(){
  //쉬운 계단 수
  var N int
  A := 0
  var arr [101][10] int
  fmt.Scan(&N)
  arr[1][0] = 0
  for i:=1; i<=9; i++{
    arr[1][i] = 1
  }
  for i:=2; i <= N; i++{
    arr[i][0] = arr[i-1][1]
    arr[i][9] = arr[i-1][8]
    for j:=1; j<=8; j++{
        arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1])%1000000000
    }
  }
  for i:=0; i<=9; i++{
    A = (A+arr[N][i])%1000000000
  }
  fmt.Println(A)
}
