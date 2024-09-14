package com.shippo.net;

import com.shippo.Shippo;
import java.util.Objects;

public class Credentials {
    private final String apiKey;
    private final String accountId;

    public Credentials(String apiKey, String accountId) {
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalArgumentException("API key cannot be null or empty");
        }
        this.apiKey = apiKey;
        this.accountId = accountId;
    }

    public static Credentials valueOf(String apiKey) {
        if (apiKey != null) {
            return new Credentials(apiKey, null);
        }
        return new Credentials(Shippo.apiKey, null);
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getAccountId() {
        return accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Credentials that = (Credentials) o;
        return Objects.equals(apiKey, that.apiKey) && Objects.equals(accountId, that.accountId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiKey, accountId);
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "apiKey='" + apiKey + '\'' +
                ", accountId='" + accountId + '\'' +
                '}';
    }
}
