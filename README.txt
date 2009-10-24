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