package com.qfedu;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.rmi.server.LoaderHandler;

import javax.imageio.ImageTypeSpecifier;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class RenJuFrame extends JFrame {
	//��������
	private RenjuBoard board;
	private boolean isBlackTurn = true;
	private boolean isGameOver = false;
	//�ڴ��е�һ��ͼ��ʵ��˫���壨�������ڵ���˸����
	private BufferedImage image = new BufferedImage(600, 620, 1);
	
	public RenJuFrame() {
		load();
		setTitle("������");
		setSize(600, 620);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				save();
			}
		});
		
		//f1����
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_F1 && !isGameOver) {
					if(board.moveBack()) {
						isBlackTurn = !isBlackTurn;
						repaint();
					}
				}
			}
		});
		//��f3������Ϸ
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_F3 && isGameOver){
					isGameOver = false;
					isBlackTurn = true;
					board.reset();
					repaint();
				}
			}
		});
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!isGameOver) {
					int x = e.getX();
					int y = e.getY();
					if(x >= 10 && x <= 590 && y >=30 && y <= 610) {
						int row = Math.round((y - 40)/40.0F);
						int col = Math.round((x - 20)/40.0F);
						RenjuPiece piece = new RenjuPiece(row, col, isBlackTurn);
						if(board.makeMove(piece)) {
							isBlackTurn = !isBlackTurn;
							repaint();
						}
						WhoWin winer = new WhoWin(board.getStates());
						if(winer.colsLeft(piece)==true || winer.colsRight(piece)||
								winer.leftButtom(piece)==true || winer.leftTop(piece)==true||
								winer.rightbuttom(piece)==true || winer.rightTop(piece)||
								winer.rowsTop(piece) ==true || winer.rowsButtom(piece)==true) {
								isGameOver = true;
								String hint = piece.isBlack()?"����Ӯ":"����Ӯ";
								JOptionPane.showMessageDialog(null, hint);
						}else{
							isGameOver = false;
						}
					}	
				}
			}
		});
	}
	//paint����������ã�ϵͳ���ã�
	//��Ϊ�ص�������callback��-ʲôʱ��ϵͳҪ��ʾ���ھͻ��Զ����ø÷���
	@Override
	public void paint(Graphics g) {
		Graphics g2 = image.getGraphics();
		super.paint(g2);
		board.draw(g2);
		//�����ڴ��л�ͼ��Ȼ����ڴ���ȡ��ͼƬ��
		g.drawImage(image, 0, 0, null);
	}
	
	public void load() {
		try(InputStream in = new FileInputStream("renju.sav");) {
			ObjectInputStream ois = new ObjectInputStream(in);
			RenjuContext context = (RenjuContext) ois.readObject();
			board = context.getBoard();
			isGameOver = context.isGameOver();
			isBlackTurn = context.isBlackTurn();
		} catch (Exception e) {
			board = new RenjuBoard();
		}
		
	}
	
	public void save() {
		RenjuContext renjuContext = new RenjuContext();
		renjuContext.setBoard(board);
		renjuContext.setGameOver(isGameOver);
		renjuContext.setBlackTurn(isBlackTurn);
		//Try-With-Resourse�﷨
		try (OutputStream out = new FileOutputStream("renju.sav")) {	
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(renjuContext);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new RenJuFrame().setVisible(true);
	}
}
