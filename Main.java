package swiggy;
import java.util.*;
class player{
	List<Integer> hcards= new ArrayList<>();
	
}

public class Main {
	/* this reverse function reverses the array that contains the order of players*/
	public static int[] reverse(int[]arr) {
		 int i, t,n=4;
	        for (i = 0; i < n / 2; i++) {
	            t = arr[i];
	            arr[i] = arr[n - i - 1];
	            arr[n - i - 1] = t;
	        }
	        return arr;
	}
	/*checks if the player has the card of same suit or same value*/
    public static boolean find_t(List<Integer>l1, int T) {
		int t =T%13;
		for(Integer i :l1) {
			if(i==t) {
				return true;
			}
			else if(T <=13 && i<=13) {
				return true;
			}
			else if(T > 13 && T<=26 && i>13 && i<=26) {
				return true;
			}
			else if(T > 26 && T<=39 && i>26 && i<=39) {
				return true;
			}
			else if(T > 39 && i>39) {
				return true;
			}
		}
		return false;
		
	}
    /*check if the two given cards have the same value or are of same suit*/
	public static boolean check(int a, int b) {
		if(a%13 == b%13) {
			return true;
		}
		else if(a <=13 && b<=13) {
			return true;
		}
		else if(a > 13 && a<=26 && b>13 && b<=26) {
			return true;
		}
		else if(a > 26 && a<=39 && b>26 && b<=39) {
			return true;
		}
		else if(a > 39 && b>39) {
			return true;
		}
		
		return false;
		
	}
	/*checks if the card is an ace*/
	public static boolean isAce(int a) {
		if(a==1 || a==14 || a==27||a==40) {
			return true;
		}
		return false;
		
	}
    /*checks if the card is a KING*/
	public static boolean isKing(int a) {
		if(a%13 == 0) {
			return true;
		}
		return false;
	}
	/*this function changes the place where it is pointing i.e the player that it is pointing to*/
	public static int changeC(int a) {
		if (a==0) {
			return 3;
		}
		if(a==1) {
			return 2;
		}
		if(a==2) {
			return 1;
		}
		if (a==3) {
			return 0;
		}
		return 0;
	}
	/*checks if the card is Queen*/
	public static boolean isQueen(int a) {
		if(a%13==12) {
			return true;
		}
		return false;
	}
	/*checks if the card is Jack*/
	public static boolean isJack(int a) {
		if(a%13 == 11) {
			return true;
		}
		return false;
	}
    /*this function was basically created to check the out of bounds but that has been taken care by try catch*/
	public static boolean che(int a) {
		if(a>52) {
			return true;
		}
		return false;
	}
	/*this function prints in case of game draw*/
	public static void print() {
		System.out.println("GAme Draw.... Start a new game");
	}
    /*the game with all the functions and rules are implimented in this function*/
	public static void play(List<Integer> p1,List<Integer> p2,List<Integer> p3,List<Integer> p4,int[]arr) {
		int t=arr[20];
		boolean play = true;
		int point =21;
		int c=0;
		int plays[]= {1,2,3,4};
		boolean flag =true;
		//System.out.println("here in plays");
		try {
		while(play) {
			flag=true;
			if(p1.isEmpty()) {
				System.out.println("PLAYER 1 IS WINNER");
				break;
			}
			if(p2.isEmpty()) {
				System.out.println("PLAYER 2 IS WINNER");
				break;
			}
			if(p3.isEmpty()) {
				System.out.println("PLAYER 3 IS WINNER");
				break;
			}
			if(p4.isEmpty()) {
				System.out.println("PLAYER 4 IS WINNER");
				break;
			}
			//System.out.println(p1.toString());
			c=c%4;
			if(plays[c]==1) {
				
				if(find_t(p1,t)) {
					//System.out.println("here in player1");
					//System.out.println(p1.toString());					
					for(int i=0;i<p1.size();i++) {
						int k1 = p1.get(i);
						if(check(k1,t)) {
							if(isAce(k1)) {
								if(isAce(t)){
									continue;
								}
								p1.remove(i);
								flag=false;
								t=k1;
								c+=2;
								break;
							}
							if(isKing(k1)) {
								if(isKing(t)){
									continue;
								}
								p1.remove(i);
								flag=false;
								t=k1;
								plays=reverse(plays);
								c = changeC(c);
								break;								
							}
							if(isQueen(k1)) {
								//System.out.println("here in player1");
								if(isQueen(t)){
									continue;
								}
								p1.remove(i);
								flag=false;
								t=k1;
								int k2 =c+1;
								k2%=4;
								if(plays[k2]==1) {
									p1.add(arr[point++]);
									if(che(point)) {
										play = false;
										print();
										break;
									}
									p1.add(arr[point++]);
									if(che(point)) {
										play = false;
										print();
										break;
									}
								}
								if(plays[k2]==2) {
									p2.add(arr[point++]);
									if(che(point)) {
										play = false;
										print();
										break;
									}
									p2.add(arr[point++]);
									if(che(point)) {
										play = false;
										print();
										break;
									}
								}
								if(plays[k2]==3) {
									p3.add(arr[point++]);
									if(che(point)) {
										play = false;
										print();
										break;
									}
									p3.add(arr[point++]);
									if(che(point)) {
										play = false;
										print();
										break;
									}
								}
								if(plays[k2]==4) {
									p4.add(arr[point++]);
									if(che(point)) {
										play = false;
										print();
										break;
									}
									p4.add(arr[point++]);
									if(che(point)) {
										play = false;
										print();
										break;
									}
								}
								c++;
								break;
							}
							if(isJack(k1)) {
								if(isJack(t)){
									continue;
								}
								p1.remove(i);
								flag=false;
								t=k1;
								int k2 =c+1;
								k2%=4;
								if(plays[k2]==1) {
									p1.add(arr[point++]);
									p1.add(arr[point++]);
									p1.add(arr[point++]);
									p1.add(arr[point++]);
								}
								if(plays[k2]==2) {
									p2.add(arr[point++]);
									p2.add(arr[point++]);
									p2.add(arr[point++]);
									p2.add(arr[point++]);
								}
								if(plays[k2]==3) {
									p3.add(arr[point++]);
									p3.add(arr[point++]);
									p3.add(arr[point++]);
									p3.add(arr[point++]);
								}
								if(plays[k2]==4) {
									p4.add(arr[point++]);
									p4.add(arr[point++]);
									p4.add(arr[point++]);
									p4.add(arr[point++]);
								}
								c++;
								break;
							}
							p1.remove(i);
							t=k1;
							c++;
							break;
							
						}
						
					}
					continue;
					
				}
				if(flag) {
					p1.add(arr[point++]);
					c++;
					continue;
				}
				
			}
			else if(plays[c]==2) {
				if(find_t(p2,t)) {
					//System.out.println("here in player2");
					//System.out.println(p2.toString());
					for(int i=0;i<p2.size();i++) {
						int k1 = p2.get(i);
						if(check(k1,t)) {
							if(isAce(k1)) {
								if(isAce(t)){
									continue;
								}
								p2.remove(i);
								flag=false;
								t=k1;
								c+=2;
								break;
							}
							if(isKing(k1)) {
								if(isKing(t)){
									continue;
								}
								p2.remove(i);
								flag=false;
								t=k1;
								plays=reverse(plays);
								c = changeC(c);
								break;								
							}
							if(isQueen(k1)) {
								if(isQueen(t)){
									continue;
								}
								p2.remove(i);
								flag=false;
								t=k1;
								int k2 =c+1;
								k2%=4;
								if(plays[k2]==1) {
									p1.add(arr[point++]);
									p1.add(arr[point++]);
								}
								if(plays[k2]==2) {
									p2.add(arr[point++]);
									p2.add(arr[point++]);
								}
								if(plays[k2]==3) {
									p3.add(arr[point++]);
									p3.add(arr[point++]);
								}
								if(plays[k2]==4) {
									p4.add(arr[point++]);
									p4.add(arr[point++]);
								}
								c++;
								break;
							}
							if(isJack(k1)) {
								if(isJack(t)){
									continue;
								}
								p2.remove(i);
								flag=false;
								t=k1;
								int k2 =c+1;
								k2%=4;
								if(plays[k2]==1) {
									p1.add(arr[point++]);
									p1.add(arr[point++]);
									p1.add(arr[point++]);
									p1.add(arr[point++]);
								}
								if(plays[k2]==2) {
									p2.add(arr[point++]);
									p2.add(arr[point++]);
									p2.add(arr[point++]);
									p2.add(arr[point++]);
								}
								if(plays[k2]==3) {
									p3.add(arr[point++]);
									p3.add(arr[point++]);
									p3.add(arr[point++]);
									p3.add(arr[point++]);
								}
								if(plays[k2]==4) {
									p4.add(arr[point++]);
									p4.add(arr[point++]);
									p4.add(arr[point++]);
									p4.add(arr[point++]);
								}
								c++;
								break;
							}
							p2.remove(i);
							flag=false;
							t=k1;
							c++;
							break;
							
						}
						
					}
					continue;
					
				}
				if(flag) {
					p2.add(arr[point++]);
					c++;
					continue;
				}
				
			}
			else if(plays[c]==3) {
				if(find_t(p3,t)) {
					//System.out.println("here in player3");
					//System.out.println(p3.toString());
					for(int i=0;i<p3.size();i++) {
						int k1 = p3.get(i);
						if(check(k1,t)) {
							if(isAce(k1)) {
								if(isAce(t)){
									continue;
								}
								p3.remove(i);
								flag=false;
								t=k1;
								c+=2;
								break;
							}
							if(isKing(k1)) {
								if(isKing(t)){
									continue;
								}
								p3.remove(i);
								flag=false;
								t=k1;
								plays=reverse(plays);
								c = changeC(c);
								break;								
							}
							if(isQueen(k1)) {
								if(isQueen(t)){
									continue;
								}
								p3.remove(i);
								flag=false;
								t=k1;
								int k2 =c+1;
								k2%=4;
								if(plays[k2]==1) {
									p1.add(arr[point++]);
									p1.add(arr[point++]);
								}
								if(plays[k2]==2) {
									p2.add(arr[point++]);
									p2.add(arr[point++]);
								}
								if(plays[k2]==3) {
									p3.add(arr[point++]);
									p3.add(arr[point++]);
								}
								if(plays[k2]==4) {
									p4.add(arr[point++]);
									p4.add(arr[point++]);
								}
								c++;
								break;
							}
							if(isJack(k1)) {
								if(isJack(t)){
									continue;
								}
								p3.remove(i);
								flag=false;
								t=k1;
								int k2 =c+1;
								k2%=4;
								if(plays[k2]==1) {
									p1.add(arr[point++]);
									p1.add(arr[point++]);
									p1.add(arr[point++]);
									p1.add(arr[point++]);
								}
								if(plays[k2]==2) {
									p2.add(arr[point++]);
									p2.add(arr[point++]);
									p2.add(arr[point++]);
									p2.add(arr[point++]);
								}
								if(plays[k2]==3) {
									p3.add(arr[point++]);
									p3.add(arr[point++]);
									p3.add(arr[point++]);
									p3.add(arr[point++]);
								}
								if(plays[k2]==4) {
									p4.add(arr[point++]);
									p4.add(arr[point++]);
									p4.add(arr[point++]);
									p4.add(arr[point++]);
								}
								c++;
								break;
							}
							p3.remove(i);
							flag=false;
							t=k1;
							c++;
							break;
							
						}
						
					}
					continue;
					
					
				}
				if(flag) {
					p3.add(arr[point++]);
					c++;
					continue;
				}
				
			}
			else if(plays[c]==4) {
				if(find_t(p4,t)) {
					//System.out.println("here in player4");
				//System.out.println(p4.toString());		
					for(int i=0;i<p4.size();i++) {
						int k1 = p4.get(i);
						if(check(k1,t)) {
							if(isAce(k1)) {
								if(isAce(t)){
									continue;
								}
								p4.remove(i);
								flag=false;
								t=k1;
								c+=2;
								break;
							}
							if(isKing(k1)) {
								if(isKing(t)){
									continue;
								}
								p4.remove(i);
								flag=false;
								t=k1;
								plays=reverse(plays);
								c = changeC(c);
								break;								
							}
							if(isQueen(k1)) {
								if(isQueen(t)){
									continue;
								}
								p4.remove(i);
								flag=false;
								t=k1;
								int k2 =c+1;
								k2%=4;
								if(plays[k2]==1) {
									p1.add(arr[point++]);
									p1.add(arr[point++]);
								}
								if(plays[k2]==2) {
									p2.add(arr[point++]);
									p2.add(arr[point++]);
								}
								if(plays[k2]==3) {
									p3.add(arr[point++]);
									p3.add(arr[point++]);
								}
								if(plays[k2]==4) {
									p4.add(arr[point++]);
									p4.add(arr[point++]);
								}
								c++;
								break;
							}
							if(isJack(k1)) {
								if(isJack(t)){
									continue;
								}
								p4.remove(i);
								flag=false;
								t=k1;
								int k2 =c+1;
								k2%=4;
								if(plays[k2]==1) {
									p1.add(arr[point++]);
									p1.add(arr[point++]);
									p1.add(arr[point++]);
									p1.add(arr[point++]);
								}
								if(plays[k2]==2) {
									p2.add(arr[point++]);
									p2.add(arr[point++]);
									p2.add(arr[point++]);
									p2.add(arr[point++]);
								}
								if(plays[k2]==3) {
									p3.add(arr[point++]);
									p3.add(arr[point++]);
									p3.add(arr[point++]);
									p3.add(arr[point++]);
								}
								if(plays[k2]==4) {
									p4.add(arr[point++]);
									p4.add(arr[point++]);
									p4.add(arr[point++]);
									p4.add(arr[point++]);
								}
								c++;
								break;
							}
							p4.remove(i);
							flag=false;
							t=k1;
							c++;
							break;
							
						}
						
					}
					continue;
					
					
				}
				if(flag) {
					p4.add(arr[point++]);
					c++;
					continue;
				}
				
			}
			

			
			if(point == 52) {
				System.out.println("Game Draw... Start a new game");
				break;
			}
			
			
		}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			print();
		}
		finally {
			
		}
		
		
	}
	/*This Function creates the deck of cards and shuffles it*/
	public static int[] makecards() {
		int arr[] = new int[52];
		Random rand = new Random();
		for(int i=1;i<53;i++) {
			arr[i-1]=i;
		}
		for (int i = 0; i < arr.length; i++) {
			int randomIndexToSwap = rand.nextInt(arr.length);
			int temp = arr[randomIndexToSwap];
			arr[randomIndexToSwap] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
    /*this function can be used to print the cards at any point*/
	public static void print(List<Integer> l) {
		for(Integer i:l) {
			print(i);
			System.out.print(" -> ");
		}
		System.out.println();
		
	}
	/*this prints the card with its original value i.e cards along with its value and suit*/
	public static void print(int k) {
		int p=k%13;
		String s="";
		if(k<=13) {
			s="Spade";
		}
		else if(k>13 && k<=26) {
			s="club";
		}
		else if(k>26 && k<=39) {
			s="diamond";
		}
		else if(k>39) {
			s="heart";
		}
		if(p>0 && p<11) {
			System.out.print(p + " of "+ s+"  ");
		}
		else if(p==0) {
			System.out.print("king" + " of "+ s+"  ");		
		}
		else if(p==1) {
			System.out.print( "ACE"+ " of "+ s+"  ");
		}
		else if(p==11) {
			System.out.print("JACK" + " of "+ s+"  ");
		}
		else if(p==12) {
			System.out.print("QUEEN" + " of "+ s+"  ");
		}
		
		
	}

    /*main function*/
	public static void main(String[] args) {

		int cards[]= makecards();
		player p1 = new player();
		player p2 = new player();
		player p3 = new player();
		player p4 = new player();
		for(int i=0;i<20;) {
			p1.hcards.add(cards[i++]);
			p2.hcards.add(cards[i++]);
			p3.hcards.add(cards[i++]);
			p4.hcards.add(cards[i++]);
			//System.out.print(i);
		
		}
		System.out.println("initial cards with player1");
		print(p1.hcards);
		System.out.println("initial cards with player2");
		print(p2.hcards);
		System.out.println("initial cards with player3");
		print(p3.hcards);
		System.out.println("initial cards with player4");
		print(p4.hcards);
		
		System.out.print("initial card on top of discard pile = ");
		print(cards[20]);
		System.out.println();
		play(p1.hcards,p2.hcards,p3.hcards,p4.hcards,cards);
		
		
	}

}
