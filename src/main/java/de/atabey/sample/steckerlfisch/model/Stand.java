package de.atabey.sample.steckerlfisch.model;

import javax.persistence.*;

/**
 * @author Fuat Atabey
 */
@Entity
public class Stand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String street;
    private String ort;


}
