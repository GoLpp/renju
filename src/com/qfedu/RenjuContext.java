package com.qfedu;

import java.io.Serializable;
/**
 * ������Ϸ�������ģ���������л�
 * @author GG bone
 *
 */
public class RenjuContext implements Serializable{
	private RenjuBoard board;
	private boolean isBlackTurn;
	private boolean isGameOver;
	
	public RenjuBoard getBoard() {
		return board;
	}
	public void setBoard(RenjuBoard board) {
		this.board = board;
	}
	public boolean isBlackTurn() {
		return isBlackTurn;
	}
	public void setBlackTurn(boolean isBlackTurn) {
		this.isBlackTurn = isBlackTurn;
	}
	public boolean isGameOver() {
		return isGameOver;
	}
	public void setGameOver(boolean isGameover) {
		this.isGameOver = isGameover;
	}
}
