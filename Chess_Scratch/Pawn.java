class Pawn extends Piece{


	public Pawn(boolean color){
		
		this.color = color;

		if(color){
		
			this.name = "P";
		}//end if
		else if(!color){

			this.name = "p";
		}//end else if

	}//end constructor
	
	public boolean MoveChoose(int[] next, boolean take){
		double slope = slope(this.position, next);
		double dist = dist(this.position, next);
		if(!take){

			if(this.color){
				
				if(slope == 1 && next[1] > this.position[1] || slope == 100 && next[1] > this.position[1]){
					
					if(dist == 1 || dist == 2){
						
						return true;

					}//end else if
					
					else{
						return false;

					}//end else

				}//end if  
				
				else{

					return false;

				}//end else

			}//end if
		
			if(!this.color){
				
				if(slope == 1 && this.position[1] > next[1] || slope == 100 && this.position[1] > next[1]){
					

					if(dist == 1 || dist == 2){
						
						return true;

					}//end else if
					
					else{
						return false;

					}//end else

				}//end if  
				
				else{

					return false;

				}//end else

			}//end if
		
	
		}//end if	
		
		else if(take){


			if(this.color){	
		
				if(slope == 1 && this.position[1] < next[1]){
					
					if(dist > 1.3 && dist < 1.5){
						
						return true;

					}//end if
					else{

						return false;

					}//end else
					
			
				}//end if

				else{

					return false;

				}//end else



			}//end if


			else if(!this.color){


				if(slope == 1 && this.position[1] > next [1]){
					
					if(dist > 1.3 && dist < 1.5){
						
						return true;

					}//end if
					else{

						return false;

					}//end else
					
			
				}//end if

				else{

					return false;

				}//end else



			}//end else if

			else{

				return false;

			}//end else

			
		}//end else if
			


		return false;

	}//end Move Choose


}//end Pawn class