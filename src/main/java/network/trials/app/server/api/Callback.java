package network.trials.app.server.api;

public interface Callback<T, E extends Exception> {
    void onSuccess(T result);

    void onFailure(E error);
}
