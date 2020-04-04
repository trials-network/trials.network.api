package network.trials.app.server.db.model;

public class Result<T> {
    private T _data;

    public Result(T data) {
        this._data = data;
    }

    public T get() {
        return _data;
    }
}
