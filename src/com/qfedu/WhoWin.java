package com.qfedu;


public class WhoWin {
	
	private BoardState[][] states;
	public WhoWin(BoardState[][] states) {
		this.states = states;
	}
	
	/**
	 * ���в����ж�ʤ��
	 * @param piece
	 * @return
	 */
	public boolean rowsButtom(RenjuPiece piece) {
		int num = 1;
		int col = piece.getCol();
		int row = piece.getRow();
		
		while(true) {
			if(states[col][row] == states[col][row+1]) {
				++num;
			}else{
				return false;
			}
			System.out.println(num);
			row = row + 1;
			if(num == 5) {
				if(piece.isBlack()){
					System.out.println("����Ӯ��");
				}else{
					System.out.println("����Ӯ��");
				}
				return true;
			}
		}
	}
	
	public boolean rowsTop(RenjuPiece piece) {
		int num = 1;
		int col = piece.getCol();
		int row = piece.getRow();
		
		while(true) {
			if(states[col][row] == states[col][row-1]) {
				++num;
			}else{
				return false;
			}
			System.out.println(num);
			row = row - 1;
			if(num == 5) {
				if(piece.isBlack()){
					System.out.println("����Ӯ��");
				}else{
					System.out.println("����Ӯ��");
				}
				return true;
			}
		}
	}
	
	/**
	 *���б����ж�ʤ�� 
	 * @param piece
	 * @return
	 */
	public boolean colsLeft(RenjuPiece piece) {
		int num = 1;
		int col = piece.getCol();
		int row = piece.getRow();
		
		while(true) {
			if(states[col][row] == states[col-1][row]) {
				++num;
			}else{
				return false;
			}
			System.out.println(num);
			col = col - 1;
			if(num == 5) {
				if(piece.isBlack()){
					System.out.println("����Ӯ��");
				}else{
					System.out.println("����Ӯ��");
				}
				return true;
			}
		}
	}
	
	public boolean colsRight(RenjuPiece piece) {
		int num = 1;
		int col = piece.getCol();
		int row = piece.getRow();
		
		while(true) {
			if(states[col][row] == states[col+1][row]) {
				++num;
			}else{
				return false;
			}
			System.out.println(num);
			col = col + 1;
			if(num == 5) {
				if(piece.isBlack()){
					System.out.println("����Ӯ��");
				}else{
					System.out.println("����Ӯ��");
				}
				return true;
			}
		}
	}
	
	/**
	 * б������������ж�ʤ��
	 * @param piece
	 * @return
	 */
	
	public boolean rightTop(RenjuPiece piece) {
		int num = 1;
		int col = piece.getCol();
		int row = piece.getRow();
		
		while(true) {
			if(states[col][row] == states[col-1][row + 1]) {
				++num;
			}else{
				return false;
			}
			System.out.println(num);
			col = col - 1;
			row = row + 1;
			if(num == 5) {
				if(piece.isBlack()){
					System.out.println("����Ӯ��");
				}else{
					System.out.println("����Ӯ��");
				}
				return true;
			}
		}
	}
	
	public boolean rightbuttom(RenjuPiece piece) {
		int num = 1;
		int col = piece.getCol();
		int row = piece.getRow();
		
		while(true) {
			if(states[col][row] == states[col+1][row+1]) {
				++num;
			}else{
				return false;
			}
			System.out.println(num);
			col = col + 1;
			row = row + 1;
			if(num == 5) {
				if(piece.isBlack()){
					System.out.println("����Ӯ��");
				}else{
					System.out.println("����Ӯ��");
				}
				return true;
			}
		}
	}
	
	public boolean leftTop(RenjuPiece piece) {
		int num = 1;
		int col = piece.getCol();
		int row = piece.getRow();
		
		while(true) {
			if(states[col][row] == states[col-1][row-1]) {
				++num;
			}else{
				return false;
			}
			System.out.println(num);
			col = col - 1;
			row = row - 1;
			if(num == 5) {
				if(piece.isBlack()){
					System.out.println("����Ӯ��");
				}else{
					System.out.println("����Ӯ��");
				}
				return true;
			}
		}
	}
	
	public boolean leftButtom(RenjuPiece piece) {
		int num = 1;
		int col = piece.getCol();
		int row = piece.getRow();
		
		while(true) {
			if(states[col][row] == states[col+1][row-1]) {
				++num;
			}else{
				return false;
			}
			System.out.println(num);
			col = col + 1;
			row = row - 1;
			if(num == 5) {
				if(piece.isBlack()){
					System.out.println("����Ӯ��");
				}else{
					System.out.println("����Ӯ��");
				}
				return true;
			}
		}
	}
}
