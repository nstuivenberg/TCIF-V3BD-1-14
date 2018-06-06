import DAO.DAOFactory;
import DAO.IPersonDAO;
import model.Person;
import java.util.List;

public class AssOne {


    public static void main(String[] args) {

        //String workingDir = System.getProperty("user.dir");
        //System.out.println("Current working directory : " + workingDir);

        DAOFactory csvFactory = DAOFactory.getDAOFactory(DAOFactory.CSV);
        IPersonDAO  personDaoFact = csvFactory.getPersonDAO();
        List<Person> aList = personDaoFact.getAllPersonsByStudentId("1667775");
        System.out.println("je vader: " + aList.size());
        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        for(int i = 0; aList.size() > i; i++) {
            System.out.println(aList.get(i).toString());
        }
    }
}
