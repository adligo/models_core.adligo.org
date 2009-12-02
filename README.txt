This is where i am going to put the core models for my web 2.0 stuff
mostly to be opensourced

The models will each have a Mutible variant (with setters) so that 
most of the time the models will be nonmutable

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