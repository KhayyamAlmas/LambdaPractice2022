package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(-5,-8,-2,-12,0,1,12,5,6,9,15,8));
        hepsiniYaz(list);
        negatifleriYaz(list);
        System.out.println("pozitifList() = " + pozitifList(list));
        System.out.println("karelerList(list) = " + karelerList(list));
        System.out.println("karelerTekrarsizList(list) = " + karelerTekrarsizList(list));
        sirala(list);
        tersSirala(list);
        System.out.println("kuplerList(list) = " + kuplerList(list));
        System.out.println("karelerYeniList(list) = " + karelerYeniList(list));
        System.out.println("topla(list) = " + topla(list));
        System.out.println("negatiflerinKareleri(list) = " + negatiflerinKareleri(list));
        System.out.println("besdenBuyukVarMi(list) = " + besdenBuyukVarMi(list));
        System.out.println("sifirdanKucukMu(list) = " + sifirdanKucukMu(list));
        System.out.println("yuzeEsit(list) = " + yuzeEsit(list));
        System.out.println("sifiraEsit(list) = " + sifiraEsit(list));
        System.out.println("ilkBesElTopla(list) = " + ilkBesElTopla(list));
        System.out.println("sonBesElTopla(list) = " + sonBesElTopla(list));
    }

    // S1: listi aralarinda bosluk birakarak yazdiriniz
    public static  void hepsiniYaz(List<Integer>l){
        l.stream().forEach(t->System.out.print(t+" "));
    }
    // S2: sadece negatif olanlari yazdir
    public static  void negatifleriYaz(List<Integer>l){
        System.out.println();
        l.stream().filter(t->t<0).forEach(t-> System.out.print(t+" "));
    }
    // S3: pozitif olanlardan yeni bir liste olustur
    public static  List<Integer> pozitifList(List<Integer>l) {
        System.out.println();
        return l.stream().filter(t -> t > 0).collect(Collectors.toList());
    }
    // S4: list in elemanlarin karelerinden yeni bir list olusturalim
    public static List<Integer> karelerList(List<Integer>l){
        System.out.println();
       return l.stream().map(t -> t*t).collect(Collectors.toList());
    }
    // S5: list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim
    public static List<Integer> karelerTekrarsizList(List<Integer>l){
        System.out.println();
        return l.stream().map(t -> t*t).distinct().collect(Collectors.toList());
    }
    // S6: listin elemanlarini kucukten buyuge siralayalim
    public static void sirala(List<Integer>l){
        System.out.println();
        l.stream().sorted().forEach(t-> System.out.print(t+" "));
    }
    // S7: listin elemanlarini buyukten kucuge siralayalim
    public static void tersSirala(List<Integer>l){
        System.out.println();
        l.stream().sorted(Comparator.reverseOrder()).forEach(t-> System.out.print(t+" "));
    }
    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    public static List<Integer> kuplerList(List<Integer>l){
        System.out.println();
        return l.stream().filter(t->t>0).map(t->t*t*t).filter(t->t%10==5).collect(Collectors.toList());
    }
    // S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim
    public static List<Integer> karelerYeniList(List<Integer>l){
        System.out.println();
        return l.stream().filter(t->t>0).map(t->t*t).filter(t->t%10!=5).collect(Collectors.toList());
    }
    // S10: list elemanlarini toplamini bulalim
    public static int topla(List<Integer>l){
        System.out.println();
        return l.stream().reduce(0,(x,y)->x+y);
    }
    // S11: peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static List<Integer> negatiflerinKareleri(List<Integer>l){
        System.out.println();
        return l.stream().
                filter(t->t<0).
                peek(t-> System.out.println("negatifler: "+t)).
                map(t->t*t).
                peek(t-> System.out.println("kareleri: "+t)).
                collect(Collectors.toList());
    }
    // S12: listeden 5 den buyuk  sayi var mi?
    public static boolean besdenBuyukVarMi(List<Integer>l){
        System.out.println();
      return   l.stream().anyMatch(t->t>5); // true
    }
    // S13: listenin tum elemanlari sifirdan kucuk mu?
    public static boolean sifirdanKucukMu(List<Integer>l){
        System.out.println();
        return   l.stream().allMatch(t->t<0); // false
    }

    // S14: listenin 100 e esit elemani yok mu ?
    public static boolean yuzeEsit(List<Integer>l){
        System.out.println();
        return l.stream().noneMatch(t->t==10); // true
    }
    // S15: listenin sifira esit elemani yok mu?
    public static boolean sifiraEsit(List<Integer>l){
        System.out.println();
        return l.stream().noneMatch(t->t==0); // false
    }
    // S16: listenin ilk 5 elemanini topla?
    public static int ilkBesElTopla(List<Integer>l){
        System.out.println();
        return l.stream().limit(5).reduce(0,(x,y)->x+y);
    }
    // S17: listenin son bes elemaninin  listele
    public static List<Integer> sonBesElTopla(List<Integer>l){
        System.out.println();
        long n=l.size()-5; // son 5 demek, 8 elemanli bir listem var son 5 icin, 5 cikardigimda 3unu atlayip son 5i yazdiracak
        return l.stream().skip(n).collect(Collectors.toList());
    }


}
