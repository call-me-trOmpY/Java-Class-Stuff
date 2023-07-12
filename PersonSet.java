import java.util.*;
import java.io.*;
import java.text.*;

public class PersonSet
{
    public static void main(String[] args)
    {
       HashSet <Person> hs = new HashSet<Person>(7);
       Calendar c = Calendar.getInstance();
       Person abeSimpson     = new Person(4000, "Mr.",  "Abe",    "Simpson", c);
       Person abrahamSimpson = new Person(7777, "Mr.",  "Abe",    "Simpson", c);
       Person abeLincoln     = new Person(16, "Mr.",  "Abe",    "Lincoln", c);

       hs.add ( new Person(666, "Mr.",  "Old",    "Scratch",c));
       hs.add ( new Person(99,  "Dr.",  "Victor", "Frankenstein",c));
       hs.add ( new Person(68,  "Mrs.", "Debbie", "Fields",c));
       hs.add ( new Person(7,   "Mr.",  "Mickey", "Mantle",c));
       hs.add ( new Person(1,   "Mr.",  "George", "Washington",c));
       hs.add ( new Person(2,   "Mrs.", "Martha", "WAshington",c));
       hs.add ( new Person(86,  "Mr.",  "Maxwell","Smart",c));
       hs.add ( abeSimpson);
       //hs.add ( abrahamSimpson);
       //hs.add ( abeLincoln);
       //hs.add ( FakePersonGenerator.makePerson("4001"));




       TreeSet<Person> treeSet = new TreeSet<Person>( new PersonIdComparator());
       treeSet.addAll(hs);

       System.out.println("Lower="+treeSet.lower(abeLincoln).displayName());
       System.out.println("Floor="+treeSet.floor(abeLincoln).displayName());
       System.out.println("Higher="+treeSet.higher(abeLincoln).displayName());
       System.out.println("Ceiling="+treeSet.ceiling(abeLincoln).displayName());


       dumpAsSet(treeSet);
       //dumpWithIterator(treeSet);

       // uses equals(Object)
       System.out.println("Contains abrahamSimpson "+hs.contains(abrahamSimpson));

       // uses equals(Person), if present
       System.out.print(abeSimpson.displayName() + " is equals " +  abrahamSimpson.displayName()+"? ");
       System.out.println(abeSimpson.equals(abrahamSimpson));
       abrahamSimpson.setId(4000);
       abrahamSimpson.setFirstName("Gabe");
       System.out.println("Contains after name was changed?  "+hs.contains(abrahamSimpson));

    }



    private static void dumpWithIterator(TreeSet <Person> hs)
    {
        System.out.println("\nvia Iterator");
        System.out.println("------------------------");
        Iterator <Person> it = hs.iterator();
        while (it.hasNext())
        {
           Person tVal =  it.next();
           System.out.println(tVal.displayName());

        }
    }

    private static void dumpAsSet(TreeSet <Person> hs)
    {
        System.out.println("\nvia Set");
        System.out.println("------------------------");
        Set<Person> set = hs;
        for (Person s: set)
        {
           System.out.println(s.displayName());
        }
    }

//   private static boolean searchContains(HashSet <Person> hs , Person p)
//    {
//        return (hs.contains(p));
//    }



}