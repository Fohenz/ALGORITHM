package main

import "fmt"

func main(){
  //이친수만들기
  /*
    이친수는 0으로 시작하지 않는다.
    이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
*/
  var N int
  var arr [100][2]int
  fmt.Scan(&N)
  arr[1][0] = 0
  arr[1][1] = 1
  for i:= 2; i <= N; i++{
    arr[i][0] = arr[i-1][0] + arr[i-1][1]
    arr[i][1] = arr[i-1][0]
  }
  fmt.Println(arr[N][0] + arr[N][1])
}
