package com.karankumar.booksapi.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * We store a partial path in our blob storage and then dynamically add the prefix needed.
 * We only accept the .jpg image file type
 */
@Table(name = "book_cover")
@Entity
@Data
public class BookCover {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    private CoverFileType smallFileType;

    @OneToOne
    private CoverFileType mediumFileType;

    @OneToOne
    private CoverFileType largeFileType;

    private static final String PREFIX = "https://bapiimagesdev.blob.core.windows.net/covers/";

    public String getPathToSmall() {
        final String suffix = "/small.jpg";
        return PREFIX + id + suffix;
    }

    public String getPathToMedium() {
        final String suffix = "/medium.jpg";
        return PREFIX + id + suffix;
    }

    public String getPathToLarge() {
        final String suffix = "/large.jpg";
        return PREFIX + id + suffix;
    }
}