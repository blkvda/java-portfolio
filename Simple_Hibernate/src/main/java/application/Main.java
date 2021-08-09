package application;

import dao.AEntityDaoHibernateImp;
import dao.BEntityDaoHibernateImp;
import dao.EntityDao;
import entities.AEntity;
import entities.BEntity;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityDao aEntityDao = new AEntityDaoHibernateImp();
        EntityDao bEntityDao = new BEntityDaoHibernateImp();

        AEntity aEntity1 = new AEntity("1st");
        AEntity aEntity2 = new AEntity("2nd");

        BEntity bEntity1 = new BEntity(123, aEntity1);

        List<BEntity> arrayList = new ArrayList<>();
        arrayList.add(bEntity1);
        aEntity1.setbEntitiesList(arrayList);

        aEntityDao.add(aEntity1);
        aEntityDao.add(aEntity2);

        System.out.println("All AEntities: " + aEntityDao.findAll());

        System.out.println("\n\nAll BEntities: " + bEntityDao.findAll());
    }
}
