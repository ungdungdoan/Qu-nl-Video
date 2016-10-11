package ui;

import java.io.Serializable;
import java.util.ArrayList;

public class Data implements Serializable {
	private ArrayList<Book> listBook = new ArrayList<Book>();
	private ArrayList<String> listBookType;
	public Data() {
	}

	public ArrayList<Book> getListBook() {
		return listBook;
	}

	public void setListBook(ArrayList<Book> listBook) {
		this.listBook = listBook;
	}

	public ArrayList<String> getListBookType() {
		listBookType = new ArrayList<String>();
		for (int i = 0; i < listBook.size(); i++) {
			boolean check = true;
			for (int j = i - 1; j >= 0; j--) {
				if (listBook.get(i).getMaloai()
						.equals(listBook.get(j).getMaloai())) {
					check = false;
					break;
				}
			}
			if (check) {
				listBookType.add(listBook.get(i).getMaloai
						());
			}
		}
		return listBookType;
	}

	public void setListGroup(ArrayList<String> listBookType) {
		this.listBookType = listBookType;
	}
}
