import java.util.*;

class Player {
	String name;
	int score;

	Player(String name, int score) {
		this.name = name;
		this.score = score;
	}
}

class Checker implements Comparator<Player> {
  	// complete this method
	public int compare(Player a, Player b) {
    if (a.score < b.score) {
      return 1;
    } else if (a.score > b.score) {
      return -1;
    } else {
      //equal
      String aName = a.name;
      String bName = b.name;
      int compRes = 0;
      int j = 0;

      for (int i = 0; i < Math.min(aName.length(), bName.length()); i++) {
        if (aName.charAt(i) < bName.charAt(j)) {
          compRes = -1;
          break;
        } else if (aName.charAt(i) > bName.charAt(j)) {
          compRes = 1;
          break;
        } else {
          //equal
          j++;
        }

        // bb bbb is ascending
        if (j == aName.length()) {
          compRes = -1;
          break;
        } else if (j == bName.length()) {
          compRes = 1;
          break;
        }
      }

      return compRes;
    }
  }
}


public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
