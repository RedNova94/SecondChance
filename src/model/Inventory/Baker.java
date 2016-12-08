

package model.Inventory;

/**
 *
 * @author Alberto Vásquez
 */

public class Baker {

    private StorageDAO productStorageRoom=null;
    
    public Baker() {
        productStorageRoom=new StorageDAO();
    }
    
    public void addStockToInventory(int dessertKey, int quantity){
        productStorageRoom.addDessertToStorage(dessertKey, quantity);
    }

}
