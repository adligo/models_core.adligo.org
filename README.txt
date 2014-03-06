The models in this project are usable with JME, GWT, JSE, LDAP and RDBs 
also each have a Mutible variant (with setters) so that 
most of the time the models will be nonmutable.

Please follow the NamedId (NamedIdMutant) examples

Note that id a storage identifier is ommited from hash_code and equals

Models in this package should be able to be used on J2ME, J2SE and GWT

also there should NOT be any collections in this package as the relations should be in Relation objects
PersonRelations(Mutant) for instance in 
models_core_relations (J2SE, GWT) or 
models_core_j2me_relations (J2ME) packages

lazy gen hashCodes in immutable objects, this is due to a 
int overflow issue with gwt
http://code.google.com/p/google-web-toolkit/issues/detail?id=4263#c0
this field is not synchronized as it should not change, but 
instead may be calculated two or three times if multiple threads call
for a hash code on a object at the same time.  Since this is only on 'immutable'
objects the hash code should always be calculated the same 
(even if its calculated multiple times).

Notes
1) LDAP entities do not generally have a version number,
so optimistic locking is generally accomplished by comparing all the fields
in the LDAP entity.  However it is still slightly confusing to have a null Version
number in a object which doesn't have a version number on disk.
Also this creates a issue with history classes as the version is in the 
VersionedLongIdentifier AND the class it self.
  I have solved this by splintering the classes as follows;
  
  Org  (no version number)
  			OrgVersioned (wraps VersionedOrganizationMutant)
  OrgMutant (no version number)
    		OrgVersionedMutant (extends OrganizationMutant adds version)
    		


Note the I_StorageIdentifier impl classes are in the models_core_relations
project due to hibernate requireing Serlizable for id classes, and Serlizable not
being available on JME.  