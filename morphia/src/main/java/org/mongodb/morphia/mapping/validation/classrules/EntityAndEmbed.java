package org.mongodb.morphia.mapping.validation.classrules;


import java.util.Set;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.mapping.MappedClass;
import org.mongodb.morphia.mapping.validation.ClassConstraint;
import org.mongodb.morphia.mapping.validation.ConstraintViolation;
import org.mongodb.morphia.mapping.validation.ConstraintViolation.Level;


/**
 * @author Uwe Schaefer, (us@thomas-daily.de)
 */
public class EntityAndEmbed implements ClassConstraint {

  public void check(final MappedClass mc, final Set<ConstraintViolation> ve) {

    if (mc.getEntityAnnotation() != null && mc.getEmbeddedAnnotation() != null) {
      new ConstraintViolation(Level.FATAL, mc, getClass(),
        "Cannot have both @" + Entity.class.getSimpleName() + " and @" + Embedded.class.getSimpleName() + " annotation at class level.");
    }

  }
}
