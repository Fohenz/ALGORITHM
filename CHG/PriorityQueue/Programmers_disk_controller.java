import java.util.ArrayList;
import java.util.PriorityQueue;

class SJF implements Comparable<SJF> {
	int date;
	int job;
	
	public SJF(int d, int j) {
		this.date = d;
		this.job = j;
	}
	
	@Override
	public int compareTo(SJF d) {
		if(this.date > d.date) return 1;
		else if(this.date < d.date) return -1;
		else
			if(this.job > d.job) return 1;
			else if(this.job < d.job) return -1;
		return 0;
	}
}

class Wait implements Comparable<Wait> {
	int date;
	int job;
	
	public Wait(int d, int j) {
		this.date = d;
		this.job = j;
	}
	
	@Override
	public int compareTo(Wait d) {
		if(this.job > d.job) return 1;
		else if(this.job < d.job) return -1;
		return 0;
	}
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
		
		// jobs 배열을 요청일 오름차순으로 정렬 (요청일이 같을 경우 처리시간 오름차순으로)
		PriorityQueue<SJF> sjf = new PriorityQueue<SJF>();
		for(int i=0; i<jobs.length; i++) {
			sjf.add(new SJF(jobs[i][0], jobs[i][1]));
		}
		
		// 요청부터 종료까지 걸린 시간을 저장할 ArrayList
		ArrayList<Integer> finish = new ArrayList<Integer>();
		
		// 가장 처음 요청온 job
		SJF s = sjf.poll();
		int today = s.date + s.job;
		finish.add(s.job);

		// 현재 날짜까지 들어온 job들 대기열 (처리시간 오름차순 정렬)
		PriorityQueue<Wait> wait = new PriorityQueue<Wait>();
		while(!sjf.isEmpty()) {
			// 현재 날짜까지 들어온 job들을 대기열에 적재
			while(!sjf.isEmpty() && sjf.peek().date <= today) {
				s = sjf.poll();
				wait.add(new Wait(s.date, s.job));
			}
			
			// 대기열이 비어있다면 -> 현재 날짜까지 들어온 요청이 없음 -> 처리할 job이 없음
			if(wait.isEmpty()) {
				s = sjf.poll();
				today = s.date + s.job;
				finish.add(s.job);
			}
			// 대기열이 안비어있다면 -> 처리할 job이 있음 -> 처리기간으로 오름차순 정렬했으므로 맨 앞에 job 꺼냄
			else {
				Wait w = wait.poll();
				today = today + w.job;
				finish.add(today - w.date);
				
				// 대기열에서 처리 못한 job들은 다시 sjf에 적재
				while(!wait.isEmpty()) {
					w = wait.poll();
					sjf.add(new SJF(w.date, w.job));
				}
			}
		}
		
		for(int i=0; i<finish.size(); i++) {
			answer += finish.get(i);
		}
		answer /= finish.size();
		return answer;
    }
}
