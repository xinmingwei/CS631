package com.library.pojo;



/**
 * @author MSI-NB
 */
public class Borrow {
    private Integer borrowNumber;
    private String borrowDate;
    private String dueDate;
    private Integer fineAmount;
    private String returnDate;
    private Integer readerId;
    private Integer copyNumber;

    public Integer getBorrowNumber() {
        return borrowNumber;
    }

    public void setBorrowNumber(Integer borrowNumber) {
        this.borrowNumber = borrowNumber;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getFineAmount() {
        return fineAmount;
    }

    public void setFineAmount(Integer fineAmount) {
        this.fineAmount = fineAmount;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public Integer getReaderId() {
        return readerId;
    }

    public void setReaderId(Integer readerId) {
        this.readerId = readerId;
    }

    public Integer getCopyNumber() {
        return copyNumber;
    }

    public void setCopyNumber(Integer copyNumber) {
        this.copyNumber = copyNumber;
    }
}
