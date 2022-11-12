import java.util.*;
class Pair{
	String str="";
}
public class Test_IPL {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number of teams");
		int number_of_teams=Integer.parseInt(sc.nextLine());
		String IPL_leaderboard[][]=new String[number_of_teams][]; 
		for(int itr_teams=0;itr_teams<number_of_teams;itr_teams++)
		{
			System.out.println("Enter the details of team "+(itr_teams+1)+" result :");
			System.out.println("Example- (GT 20 Win Win Loss Loss Win)");
			System.out.print("->");
			String dataof_team=sc.nextLine();
			IPL_leaderboard[itr_teams]=(dataof_team.trim()).split(" ");
		}
//		String[][] IPL_leaderboard = {
//				{"GT","20","Win","Win","Loss","Loss","Win"},
//				{"LSG","18","Win","Loss","Loss","Win","Win"},
//				{"RR","16","Win","Loss","Win","Loss","Loss"},
//				{"DC","14","Win","Win","Loss","Win","Loss"},
//				{"RCB","14","Loss","Win","Win","Loss","Loss"},
//				{"KKR","12","Loss","Win","Win","Loss","Win"},
//				{"PBKS","12","Loss","Win","Loss","Win","Loss"},
//				{"SRH","12","Win","Loss","Loss","Loss","Loss"},
//				{"CSK","8","Loss","Loss","Win","Loss","Win"},
//				{"MI","6","Loss","Win","Loss","Win","Win"},
//				};
		
		
		for(int teamRank=0;teamRank<number_of_teams;teamRank++)
		{
			
			for(int coloumn=0;coloumn<7;coloumn++)
			{
				System.out.print(IPL_leaderboard[teamRank][coloumn]+" ");
			}
			System.out.println();
		}
		
		
		HashMap<String,Integer> teamWith2_consi_losses=new HashMap<String,Integer>();
		for(int teamRank=0;teamRank<number_of_teams;teamRank++)
		{
			String prev="";
			
			for(int coloumn=2;coloumn<7;coloumn++)
			{
				//System.out.println(IPL_leaderboard[teamRank][coloumn]);
				if((IPL_leaderboard[teamRank][coloumn].trim()).equals("Loss"))
				{
					if(prev.equals(IPL_leaderboard[teamRank][coloumn]))
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
		
		
		for(int teamRank=0;teamRank<number_of_teams;teamRank++)
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
					
					if(IPL_leaderboard[teamRank][coloumn].equals("Loss"))
					{
						
						if(prev.equals(IPL_leaderboard[teamRank][coloumn]))
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
						if(prev.equals(IPL_leaderboard[teamRank][coloumn]))
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
		int average_of_points=0;
		if(teamWith2_consi_losses.size()>0)
		{
			average_of_points=sumOfPoints/teamWith2_consi_losses.size();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("Average points of there filtered teams- "+average_of_points);
		
	}

}
