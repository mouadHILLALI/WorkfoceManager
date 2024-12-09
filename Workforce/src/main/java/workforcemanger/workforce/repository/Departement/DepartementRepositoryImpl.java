package workforcemanger.workforce.repository.Departement;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import workforcemanger.workforce.configuration.SessionFactoryUtil;
import workforcemanger.workforce.model.Departement;
import workforcemanger.workforce.repository.Repository;

public class DepartementRepositoryImpl implements Repository {
    final SessionFactory sessionFactory;
    public DepartementRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public <T> T create(T t) {
      if (t instanceof Departement) {
          Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
          sessionFactory.getCurrentSession().save(t);
          transaction.commit();
          return (T) t;
      }
        return t;
    }
//    public Departement

    @Override
    public <T> T delete(T t) {
        return null;
    }

    @Override
    public <T> T update(T t) {
        return null;
    }

    @Override
    public <T> T get(T t) {
        return null;
    }
}
