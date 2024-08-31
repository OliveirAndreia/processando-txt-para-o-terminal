public abstract class Item {
    protected String title;
    protected String publisher;
    protected int year;
    protected boolean isAvailable;

    public Item(String title, String publisher, int year) {
        this.title = title;
        this.publisher = publisher;
        this.year = year;
        isAvailable = true;
    }

    public void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Material emprestado (" + this + ").");
        } else {
            System.out.println("Material não disponível para empréstimo (" + this + ").");
        }
    }

    public void returnMaterial() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Material devolvido (" + this + "). ");
        } else {
            System.out.println("Material nao esta sob emprestimo (" + this + ") .");
        }
    }

    public abstract void showDetails();
}
