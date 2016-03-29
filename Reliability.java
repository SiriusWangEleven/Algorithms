
import java.util.Arrays;
import java.util.Scanner;

public class Reliability
{
	static Scanner in = new Scanner(System.in);
	static double r[] =
	{ 0.9, 0.85, 0.95, 0.75, 0.8, 0.85 };
	static int cnt2[] = new int[6]; //server deployment
	static int cnt[] =
	{ 1, 1, 1, 1, 1, 1 };
	static double myAns;//serial reliability
	public static void main(String[] args)
	{
		int now = 1;
		myAns = 0;
		dfs(now);
		System.out.println(myAns);
		System.out.println(Arrays.toString(cnt2));
	}

	static void dfs(int now)
	{
		if (now == 5)
		{
			if (calAll() > myAns)
			{
				myAns = calAll();
				System.arraycopy(cnt, 0, cnt2, 0, 6);
			}
			//cntNum++;
			//System.out.println(cntNum+" "+Arrays.toString(cnt));
			return;
		}
		for (int i = 0; i < 6; i++)
		{
			cnt[i]++;
			dfs(now + 1);
			cnt[i]--;
		}
	}

	static double calAll()
	{
		double ans = 1;
		for (int i = 0; i < r.length; i++)
			ans *= (1 - Math.pow(1 - r[i], cnt[i]));

		return ans;
	}

}