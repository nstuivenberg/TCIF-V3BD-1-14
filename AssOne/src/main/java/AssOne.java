import DAO.DAOFactory;
import DAO.IPersonDAO;
import model.Person;
import java.util.List;

public class AssOne {


    public static void main(String[] args) {

        DAOFactory csvFactory = DAOFactory.getDAOFactory(DAOFactory.CSV);
        IPersonDAO  personDaoFact = csvFactory.getPersonDAO();
        List<Person> aList = personDaoFact.getAllPersonsByStudentId("1667775");


        for(int i = 0; aList.size() > i; i++) {
            System.out.println(aList.get(i).toString());
        }
    }
}
