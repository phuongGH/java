package format;


public class TableEdit {
     private int tableId;
     private String categorizetable;
     private int maxPerson;

    public TableEdit(int tableId, String categorizetable, int maxPerson) {
        this.tableId = tableId;
        this.categorizetable = categorizetable;
        this.maxPerson = maxPerson;
    }

    public TableEdit() {
    }

    public String getCategorizetable() {
        return categorizetable;
    }

    public void setCategorizetable(String categorizetable) {
        this.categorizetable = categorizetable;
    }

   
    public int getTableId() {
        return this.tableId;
    }
    
    public void setTableId(int tableId) {
        this.tableId = tableId;
    }

    public int getMaxPerson() {
        return this.maxPerson;
    }
    
    public void setMaxPerson(int maxPerson) {
        this.maxPerson = maxPerson;
    }
}
