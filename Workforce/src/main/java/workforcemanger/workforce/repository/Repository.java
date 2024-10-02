package workforcemanger.workforce.repository;

public interface Repository {
    public abstract <T> T create(T t);
    public abstract <T> T delete(T t);
    public abstract <T> T update(T t);
    public abstract <T> T get(T t);
}
