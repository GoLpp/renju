package com.qfedu;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * ����
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
	
	private Color backgroundColor;	//����ɫ
	private List<RenjuPiece> pieces;	//����
	private BoardState[][] states; //��ʾ����״̬�Ķ�ά����
	
	/**
	 * ������
	 */
	public RenjuBoard() {
		this(DEFAULT_BGCOLOR);
	}
	
	/**
	 * 
	 * @param backgroundColor ����ɫ
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
	 * �������������,��״̬
	 * @return
	 */
	public List<RenjuPiece> getPieces() {
		return pieces;
	}
	
	public BoardState[][] getStates() {
		return states;
	}

	/**
	 * @param ����
	 * @return ����ɹ�����true��ʧ�ܷ���false
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
	 * ����
	 * @return ���Ի��巵��true���򷵻�false
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
	 * ��������
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
	 * ��������
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
		
		//��������
		int num = pieces.size()-1;
		for(RenjuPiece renjuPiece:pieces) {
			renjuPiece.draw(g);
			if((pieces.size()-1) == num) {
				g.drawRect(pieces.get(pieces.size() - 1).getCol() * 40, 20 + 40*pieces.get(pieces.size()-1).getRow(), 40, 40);
			}
		}
	}
}
