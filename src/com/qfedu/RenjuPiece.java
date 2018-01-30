package com.qfedu;

import java.awt.Color;
import java.awt.Graphics;
import java.io.Serializable;

/**
 * 棋子
 * @author Administrator
 *
 */
public class RenjuPiece implements Serializable{
	private int row;
	private int col;
	private boolean black;
	
	/**
	 * 
	 * @param row 列
	 * @param col 行
	 * @param black 是不是黑棋
	 */
	public RenjuPiece(int row, int col, boolean black) {
		super();
		this.row = row;
		this.col = col;
		this.black = black;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public boolean isBlack() {
		return black;
	}
	
	/**
	 * 
	 * @param g 画棋子
	 */
	public void draw(Graphics g) {
		g.setColor(black?Color.BLACK:Color.WHITE);
		g.fillOval(40*col, 20 + 40*row, 40, 40);
	}
}
