package bean;

public class BookOperation {
    private int id;
    private String title;
    private String operation;
    private int userId;

    public BookOperation(int id, String title,String operation){
        this.id = id;
        this.title = title;
        this.operation = operation;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId){
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
