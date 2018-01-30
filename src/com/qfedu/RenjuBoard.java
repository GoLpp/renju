package com.qfedu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 棋盘
 * @author Administrator
 *
 */
public class RenjuBoard implements Serializable{
	public static final int LEFT = 20;
	public static final int TOP = 40;
	public static final int ROWS = 15;
	public static final int COLS = 15;
	public static final int SIZE = 40;
	public static final Color DEFAULT_BGCOLOR = new Color(194, 138, 98);
	int num = 0;
	
	private Color backgroundColor;	//背景色
	private List<RenjuPiece> pieces;	//棋子
	private BoardState[][] states; //表示棋盘状态的二维数组
	
	/**
	 * 构造器
	 */
	public RenjuBoard() {
		this(DEFAULT_BGCOLOR);
	}
	
	/**
	 * 
	 * @param backgroundColor 背景色
	 */
	public RenjuBoard(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
		this.pieces = new ArrayList<>();
		this.states = new BoardState[15][15];
		this.reset();
		//this.pieces.add(new RenjuPiece(4, 6, true));
		//this.pieces.add(new RenjuPiece(7, 8, false));
	}
	
	/**
	 * 获得五子器容器,及状态
	 * @return
	 */
	public List<RenjuPiece> getPieces() {
		return pieces;
	}
	
	public BoardState[][] getStates() {
		return states;
	}

	/**
	 * @param 走棋
	 * @return 走棋成功返回true，失败返回false
	 */
	public boolean makeMove(RenjuPiece piece) {
		int row = piece.getRow();
		int col = piece.getCol();
		if(states[col][row] == BoardState.EMPTY) {
			pieces.add(piece);
			states[col][row] = piece.isBlack() ? 
					BoardState.BLACK:BoardState.WHITE;
			return true;
		}
		return false;
	}
	
	/**
	 * 悔棋
	 * @return 可以悔棋返回true否则返回false
	 */
	public boolean moveBack() {
		if(pieces.size() > 0) {
			RenjuPiece lastPiece = pieces.remove(pieces.size() - 1);
			states[lastPiece.getCol()][lastPiece.getRow()] = BoardState.EMPTY;
			return true;
		}
		return false;
	}
	
	/**
	 * 重置棋盘
	 */
	public void reset() {
		pieces.clear();
		for(int i = 0; i < states.length; ++i) {
			for(int j = 0; j < states[i].length; ++j){
				states[i][j] = BoardState.EMPTY;
			}
		}
	}
	
	/**
	 * 绘制棋盘
	 * @param g
	 */
	public void draw(Graphics g) {
		g.setColor(backgroundColor);
		g.fillRect(0, 0, 600, 620);
		g.setColor(Color.BLACK);
		for (int i = 0; i < 15; i++) {
			g.drawLine(20, 40 + i*40, 580, 40 + i*40);
			g.drawLine(20 + i*40, 40, 20 + i*40, 600);
		}
		g.fillOval(295, 315, 10, 10);
		g.fillOval(135, 155, 10, 10);
		g.fillOval(455, 475, 10, 10);
		g.fillOval(135, 475, 10, 10);
		g.fillOval(455, 155, 10, 10);
		((Graphics2D)g).setStroke(new BasicStroke(4));
		g.drawRect(16, 36, 568, 568);
		
		//绘制棋子
		int num = pieces.size()-1;
		for(RenjuPiece renjuPiece:pieces) {
			renjuPiece.draw(g);
			if((pieces.size()-1) == num) {
				g.drawRect(pieces.get(pieces.size() - 1).getCol() * 40, 20 + 40*pieces.get(pieces.size()-1).getRow(), 40, 40);
			}
		}
	}
}
