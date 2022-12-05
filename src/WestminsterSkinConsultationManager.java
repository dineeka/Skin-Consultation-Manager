public class WestminsterSkinConsultationManager implements SkinConsultationManager{
    static int count;

    @Override
    public void add() {
        new Doctor();
        count++;
    }

    @Override
    public void delete() {
        count--;
    }

    @Override
    public void print() {
        System.out.println("");
    }

    @Override
    public void save() {
        System.out.println("saved successfully!");
    }
}
