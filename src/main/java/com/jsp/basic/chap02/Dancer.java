package com.jsp.basic.chap02;

import java.util.List;
import java.util.Objects;

// 댄서의 1명의 정보를 가질 객체의 설계도
public class Dancer {

    private String name; // 댄서이름
    private String crewName; // 크루 이름
    private DanceLevel danceLevel; // 수준
    private List<Genre> genres; // 장르 목록

    public Dancer() {
    }

    public Dancer(String name, String crewName, DanceLevel danceLevel, List<Genre> genres) {
        this.name = name;
        this.crewName = crewName;
        this.danceLevel = danceLevel;
        this.genres = genres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrewName() {
        return crewName;
    }

    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }

    public DanceLevel getDanceLevel() {
        return danceLevel;
    }

    public void setDanceLevel(DanceLevel danceLevel) {
        this.danceLevel = danceLevel;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public String toString() {
        return "Dancer{" +
                "name='" + name + '\'' +
                ", crewName='" + crewName + '\'' +
                ", danceLevel=" + danceLevel +
                ", genres=" + genres +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dancer dancer = (Dancer) o;
        return Objects.equals(name, dancer.name) && Objects.equals(crewName, dancer.crewName) && danceLevel == dancer.danceLevel && Objects.equals(genres, dancer.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, crewName, danceLevel, genres);
    }
}
