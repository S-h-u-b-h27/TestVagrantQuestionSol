import java.util.*;
class Pair{
	String str="";
}
public class Test_IPL {

	public static void main(String[] args) {
		String[][] IPL_leaderboard = {
				{"GT","20","Win","Win","Loss","Loss","Win"},
				{"LSG","18","Win","Loss","Loss","Win","Win"},
				{"RR","16","Win","Loss","Win","Loss","Loss"},
				{"DC","14","Win","Win","Loss","Win","Loss"},
				{"RCB","14","Loss","Win","Win","Loss","Loss"},
				{"KKR","12","Loss","Win","Win","Loss","Win"},
				{"PBKS","12","Loss","Win","Loss","Win","Loss"},
				{"SRH","12","Win","Loss","Loss","Loss","Loss"},
				{"CSK","8","Loss","Loss","Win","Loss","Win"},
				{"MI","6","Loss","Win","Loss","Win","Win"},
				};
		
		
		for(int teamRank=0;teamRank<10;teamRank++)
		{
			
			for(int coloumn=0;coloumn<7;coloumn++)
			{
				System.out.print(IPL_leaderboard[teamRank][coloumn]+" ");
			}
			System.out.println();
		}
		
		
		HashMap<String,Integer> teamWith2_consi_losses=new HashMap<String,Integer>();
		String [][] filtered_team=new String[10][4];
		for(int teamRank=0;teamRank<10;teamRank++)
		{
			String prev="";
			
			for(int coloumn=2;coloumn<7;coloumn++)
			{
				if(IPL_leaderboard[teamRank][coloumn]=="Loss")
				{
					if(prev==IPL_leaderboard[teamRank][coloumn])
					{
						teamWith2_consi_losses.put(IPL_leaderboard[teamRank][0],Integer.parseInt(IPL_leaderboard[teamRank][1]));
					}
				}
				prev=IPL_leaderboard[teamRank][coloumn];
			}
			prev="";
		}
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(teamWith2_consi_losses.keySet());
		System.out.println();
		System.out.println();
		System.out.println();
		
		
		for(int teamRank=0;teamRank<10;teamRank++)
		{
			String prev="";
			int win_count=0;
			int loss_count=0;
			int max_win=0;
			int max_loss=0;
			if(teamWith2_consi_losses.containsKey(IPL_leaderboard[teamRank][0]))
			{
				for(int coloumn=2;coloumn<7;coloumn++)
				{
					
					if(IPL_leaderboard[teamRank][coloumn]=="Loss")
					{
						if(prev==IPL_leaderboard[teamRank][coloumn])
						{
							loss_count++;
						}
						else
						{
							win_count=0;
							loss_count=1;
						}
					}
					else
					{
						if(prev==IPL_leaderboard[teamRank][coloumn])
						{
							win_count++;
						}
						else
						{
							loss_count=0;
							win_count=1;
						}
					}
					max_win=Math.max(win_count,max_win );
					max_loss=Math.max(loss_count,max_loss);
					prev=IPL_leaderboard[teamRank][coloumn];
					
				}
				System.out.println(IPL_leaderboard[teamRank][0]+ " - "+ (max_win>1?max_win:0)+" win and "+ (max_loss>1?max_loss:0)+" - loss.");
				max_win=0;
				max_loss=0;
				loss_count=0;
				win_count=0;
				prev="";
			}
		}
		
		
		
		
		int sumOfPoints=0;
		for(String filtered_teams : teamWith2_consi_losses.keySet())
		{
			sumOfPoints=sumOfPoints+teamWith2_consi_losses.get(filtered_teams);
		}
		
		int average_of_points=sumOfPoints/teamWith2_consi_losses.size();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Average points of there filtered teams- "+average_of_points);
		
	}

}
