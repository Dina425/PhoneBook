package manager;

import models.Contacts;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {
    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list=new ArrayList<>();



        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> contactSuccess(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{Contacts.builder()
                .name("Kobby")
                .lastname("Yassy")
                .phoneNumber("178454542344")
                .email("asdas@gmail.com")
                .address("akko")
                .description("sdfsdf")
                .build()
        });
        list.add(new Object[]{Contacts.builder()
                .name("KobbyQ")
                .lastname("Yassy")
                .phoneNumber("178454542345")
                .email("asdas1@gmail.com")
                .address("akko")
                .build()
        });



        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> contactWrongPhone(){
        List<Object[]> list=new ArrayList<>();
        list.add(new Object[]{Contacts.builder()
                .name("KobbyQ")
                .lastname("Yassy")
                .phoneNumber("")
                .email("asdas1@gmail.com")
                .address("akko")
                .build()
        });
        list.add(new Object[]{Contacts.builder()
                .name("KobbyQ")
                .lastname("Yassy")
                .phoneNumber("17845")
                .email("asdas1@gmail.com")
                .address("akko")
                .build()
        });
        list.add(new Object[]{Contacts.builder()
                .name("KobbyQ")
                .lastname("Yassy")
                .phoneNumber("1784543234242342342542345")
                .email("asdas1@gmail.com")
                .address("akko")
                .build()
        });




        return list.iterator();
    }
    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list=new ArrayList<>();
        BufferedReader reader=new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();

        while (line!=null){
            String[] all=line.split(",");
            list.add(new Object[]{Contacts.builder()
                    .name(all[0])
                    .lastname(all[1])
                    .email(all[2])
                    .phoneNumber(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line= reader.readLine();
        }



        return list.iterator();
    }


}
