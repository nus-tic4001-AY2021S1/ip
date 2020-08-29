public class MakeDoneTasks extends ShowTasks {


    ShowTasks showTasks = new ShowTasks();

    public MakeDoneTasks(){

    }

    public void makeDone(String makeDone){

        String clean = makeDone.replaceAll("\\D+","");
        int i = Integer.parseInt(clean);
        //System.out.println(i);
        showTasks.check.set(i-1,showTasks.tick);

    }
}
