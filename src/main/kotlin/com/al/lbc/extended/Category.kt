package com.al.lbc.extended

enum class Category(val channel: String, val hasSubcategories: Boolean = false) {
    EMPLOI("_emploi_", true),
    OFFRES_D_EMPLOI("offres_d_emploi"),
    // region Vehicules
    VEHICULES("vehicules", true),
    VOITURES("voitures"),
    MOTOS("motos"),
    CARAVANING("caravaning"),
    UTILITAIRES("utilitaires"),
    EQUIPEMENT_AUTO("equipement_auto"),
    EQUIPEMENT_MOTO("equipement_moto"),
    EQUIPEMENT_CARAVANING("equipement_caravaning"),
    NAUTISME("nautisme"),
    EQUIPEMENT_NAUTISME("equipement_nautisme"),
    // endregion
    // region Immobilier
    IMMOBILIER("_immobilier_", true),
    VENTES_IMMOBILIERES("ventes_immobilieres"),
    LOCATIONS("locations"),
    COLOCATIONS("colocations"),
    BUREAUX_COMMERCES("bureaux_commerces"),
    // endregion
    // region Vacances
    VACANCES("_vacances_", true),
    LOCATIONS_GITES("locations_gites"),
    CHAMBRES_D_HOTES("chambres_d_hotes"),
    CAMPINGS("campings"),
    HOTELS("hotels"),
    HEBERGEMENTS_INSOLITES("hebergements_insolites"),
    // endregion
    // region Multimedia
    MULTIMEDIA("_multimedia_", true),
    INFORMATIQUE("informatique"),
    CONSOLES_JEUX_VIDEO("consoles_jeux_video"),
    IMAGE_SON("image_son"),
    TELEPHONIE("telephonie"),
    // endregion
    // region Loisirs
    LOISIRS("_loisirs_", true),
    DVD_FILMS("dvd_films"),
    CD_MUSIQUE("cd_musique"),
    LIVRES("livres"),
    ANIMAUX("animaux"),
    VELOS("velos"),
    SPORT_HOBBIES("sport_hobbies"),
    INSTRUMENTS_DE_MUSIQUE("instruments_de_musique"),
    COLLECTION("collection"),
    JEUX_JOUETS("jeux_jouets"),
    VINS_GASTRONOMIE("vins_gastronomie"),
    // endregion
    // region Materiel professionnel
    MATERIEL_PROFESSIONNEL("_materiel_professionnel_", true),
    MATERIAL_AGRICOLE("materiel_agricole"),
    TRANSPORT_MANUTENTION("transport_manutention"),
    BTP_CHANTIER_GROS_OEUVRE("btp_chantier_gros_oeuvre"),
    OUTILLAGE_MATERIAUX_2ND_OEUVRE("outillage_materiaux_2nd_oeuvre"),
    EQUIPEMENTS_INDUSTRIELS("equipements_industriels"),
    RESTAURATION_HOTELLERIE("restauration_hotellerie"),
    FOURNITURE_DE_BUREAU("fournitures_de_bureau"),
    COMMERCES_MARCHES("commerces_marches"),
    MATERIEL_MEDICAL("materiel_medical"),
    // endregion
    // region Services
    SERVICES("_services_", true),
    PRESTATIONS_DE_SERVICES("prestations_de_services"),
    BILLETERIE("billeterie"),
    EVENEMENTS("evenements"),
    COURS_PARTICULIERS("cours_particuliers"),
    COVOITURAGE("covoiturage"),
    // endregion
    // region Maison
    MAISON("_maison_", true),
    AMEUBLEMENT("ameublement"),
    ELECTROMENAGER("electromenager"),
    ARTS_DE_LA_TABLE("arts_de_la_table"),
    DECORATION("decoration"),
    LINGE_DE_MAISON("linge_de_maison"),
    BRICOLAGE("bricolage"),
    JARDINAGE("jardinage"),
    VETEMENTS("vetements"),
    CHAUSSURES("chaussures"),
    ACCESSOIRES_BAGAGERIE("accessoires_bagagerie"),
    MONTRES_BIJOUX("montres_bijoux"),
    EQUIPEMENT_BEBE("equipement_bebe"),
    VETEMENTS_BEBE("vetements_bebe"),
    // endregion
    MISC("__", true),
    AUTRES("autres")
}