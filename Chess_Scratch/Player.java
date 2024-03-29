import java.util.*;
public abstract class Player{
	
	protected Pawn pawn;
	protected Rook rook;
	protected Knight knight;
	protected boolean color;
	protected Vector<int[]> vecpos;
/* ***NOTE***
	You can make the array of piece positions by
	using a 2d array and getPos() methods.

	For Instance:

	int[][] array = {this.rook.getPos(), this.knight.getPos(), this.queen.getPos(), etc};
	
*/
	public Player(boolean color){
		this.vecpos = new Vector<int[]>();
		this.color = color;
		this.rook = new Rook(this.color);
		this.knight = new Knight(this.color);
		this.pawn = new Pawn(this.color);
	}//end constructor
		
	public <J extends Player> boolean MoveCheck(J player, int[] pos, int[] next, boolean take){
		int[] arK = this.knight.getPos();
		int[] arR = this.rook.getPos();
		int[] arP = this.pawn.getPos();
		
		if(Arrays.equals(pos, arK)){
			
			if(!Arrays.equals(next, arR) && !Arrays.equals(next, arP) && this.knight.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputted next move is valid
					
				if(collision(player,arK,next)){//collision method call
					
					this.knight.setPos(next);
					return true;
				}//end if

			}//end if
			else{
				return false;
			}//end else
			
		}//end if
		else if(Arrays.equals(pos, arR)){

			if(!Arrays.equals(next, arK) && !Arrays.equals(next, arP) && this.rook.MoveChoose(next)){//If statement  checks if arrays are the same and if the inputted next move is valid


	
				if(collision(player,arR,next)){
					
					this.rook.setPos(next);
					return true;
				}//end if

			}//end if
			else{
				return false;
			}//end else
		}//end else if
		
		else if(Arrays.equals(pos, arP)){

			if(!Arrays.equals(next, arK) && !Arrays.equals(next, arR) && this.pawn.MoveChoose(next, take)){



	
				if(collision(player,arP,next)){
					
					this.pawn.setPos(next);
					return true;
				}//end if

			}//end if
			else{

				return false;
			}//end else


		}//end else if

		return false;
	}//end MoveCheck
	
	public <J extends Player> boolean collision(J player, int[] pos, int[] next){
	/*This method determines if the selected piece has a slope that is the same as another piece on
	  the board and the selected move position. If the slope is the same and the distance between the
	  other piece on the board is and the selected piece is less than the distance between the selected 
	  next position and the next piece, then the method returns false. Otherwise, it returns true
	*/
		
		int[] arK = this.knight.getPos();
		int[] arR = this.rook.getPos();
		int[] arP = this.pawn.getPos();
		int[] pArP = player.pawn.getPos();
		int[] pArK = player.knight.getPos();
		int[] pArR = player.rook.getPos();
		/*Debugger's Corner*/


		boolean state = true;
		/*I used a boolean variable here as a catch all
		  so that I can check every piece for collision
		  in case of a situation where there are multiple cases
		  meeting the criteria for a false method return 
		*/

		/*----------------------------------Rook if--------------------------*/
		if(Arrays.equals(pos, this.rook.getPos())){//If determines which piece has been selected
			



			if(this.rook.slope(arR, arK) == this.rook.slope(arR, next)){//if determines if slopes are the same between other piece and next
				if(this.rook.dist(arR,arK) < this.rook.dist(arR, next)){//if determines if distance between piece is less than next
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(arR, arP) == this.rook.slope(arR, next)){
				if(this.rook.dist(arR, arP) < this.rook.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(arR, pArK) == this.rook.slope(arR, next)){
				if(this.rook.dist(arR, pArK) < this.rook.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(arR, pArR) == this.rook.slope(arR, next)){
			
				if(this.rook.dist(this.rook.getPos(), pArR) < this.rook.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.rook.slope(arR, pArP) == this.rook.slope(arR, next)){
				if(this.rook.dist(arR, pArP) < this.rook.dist(arR, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

		}//end if

		/*----------------------Knight if--------------------------------*/
		else if(Arrays.equals(pos, this.knight.getPos())){//No arguments for knight piece because of its moveset

			state = true;



		}//end if

		/*----------------------Pawn if----------------------------------*/
		else if(Arrays.equals(pos, this.pawn.getPos())){



			if(this.pawn.slope(arP, arK) == this.pawn.slope(arP, next)){
				if(this.pawn.dist(arP, arK) < this.pawn.dist(arP, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.pawn.slope(arP, arR) == this.pawn.slope(arP, next)){
				if(this.pawn.dist(arP, arR) < this.pawn.dist(arP, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.pawn.slope(arP, pArK) == this.pawn.slope(arP, next)){
				if(this.pawn.dist(arP, pArK) < this.pawn.dist(arP, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.pawn.slope(arP, pArR) == this.pawn.slope(arP, next)){
			
				if(this.pawn.dist(arP, pArR) < this.pawn.dist(arP, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if

			if(this.pawn.slope(arP, pArP) == this.pawn.slope(arP, next)){
				if(this.pawn.dist(arP, pArP) < this.pawn.dist(arP, next)){
					state = false;
				}//end if
				else{
					state = true;
				}//end else

			}//end if


		}//end if
		

		return state;
	}//end Collision


}//end Player abstract class
