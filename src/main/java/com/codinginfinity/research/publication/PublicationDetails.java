package com.codinginfinity.research.publication;

import com.codinginfinity.research.core.BaseEntity;

import java.time.LocalDate;

/**
 * Created by andrew on 2016/04/11.
 */
public class PublicationDetails extends BaseEntity {

    private static final long serialVersionUID = 3466316525188373405L;

    private String title;
    private LocalDate envisagedPublicationDate;

    public PublicationDetails(String title, LocalDate envisagedPublicationDate) {
        this.title = title;
        this.envisagedPublicationDate = envisagedPublicationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PublicationDetails)) return false;

        PublicationDetails that = (PublicationDetails) o;

        if (getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
        return getEnvisagedPublicationDate() != null ? getEnvisagedPublicationDate().equals(that.getEnvisagedPublicationDate()) : that.getEnvisagedPublicationDate() == null;

    }

    @Override
    public int hashCode() {
        int result = getTitle() != null ? getTitle().hashCode() : 0;
        result = 31 * result + (getEnvisagedPublicationDate() != null ? getEnvisagedPublicationDate().hashCode() : 0);
        return result;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getEnvisagedPublicationDate() {
        return envisagedPublicationDate;
    }

    public void setEnvisagedPublicationDate(LocalDate envisagedPublicationDate) {
        this.envisagedPublicationDate = envisagedPublicationDate;
    }
}
