package stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

public class DataTableSteps {
    @Given("single List")
    public void singleList(DataTable dataTable) {
        List<String> list = dataTable.asList();

        System.out.println(" single List ");
        System.out.println(list);  // todo [a,b,c,d]
//        for (String s: list) {    // burda hepsini tek tek yansitiyor  a,b,c,d,
//            System.out.print(s + ", ");
//        }
//        System.out.println(listc.get(2));

        System.out.println("----------------------------------");

    }

    @Given("multi line single list")
    public void multiLineSingleList(DataTable dataTable) {

        List<String> list = dataTable.asList();

        System.out.println(" multi line single List ");

        for (String s : list) {
            System.out.print(s + ", ");
        }
        System.out.println(list.get(2));

        System.out.println("----------------------------------");

    }

    @Given("list of lists")
    public void listOfLists(DataTable dataTable) {

        List<List<String>> lists = dataTable.asLists();

        System.out.println(" list of List ");

        System.out.println(lists);

        for (List<String> list : lists) {
            System.out.println(list);
        }

        System.out.println("----------------------------------");

    }

    @Given("maps")
    public void maps(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);

        System.out.println(" map ");

        System.out.println(map);
        System.out.println(map.get("c"));

        System.out.println("----------------------------------");
    }

    @Given("list of maps")
    public void listOfMaps(DataTable dataTable) {
       List<Map<String,String>> listOfmaps = dataTable.asMaps();

        System.out.println(" List of Maps ");
        System.out.println(listOfmaps);

        for (Map<String, String> map : listOfmaps) {
            System.out.println(map);
        }

        for (Map<String, String> map : listOfmaps) {
            System.out.println(map.get("c"));
        }

        System.out.println("----------------------------------");
    }

    @Given("user name {string}")
    public void userName(String userName) {

        System.out.println(userName);

    }
}
