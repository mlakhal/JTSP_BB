package Algorithm;


// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.A060D6E4-EF7F-6727-2424-F80226DC4C02]
// </editor-fold> 
public class Edge {

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.C5FD86FA-E112-EF68-F4B5-CCB85D55FB0B]
    // </editor-fold> 
    private int from;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.60D35194-7F76-8658-511D-5685AC4D0A39]
    // </editor-fold> 
    private int to;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.B2837C88-57ED-5D5E-C43E-2C8EC25C936F]
    // </editor-fold> 
    public Edge (int f, int t) {
        from=f;
        to=t;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.9E3AE379-83A9-1BE5-1443-DCDB4DAE6F9F]
    // </editor-fold> 
    public int getFrom () {
        return from;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.BEED6CF0-DE14-275D-B09B-AE453179C3CC]
    // </editor-fold> 
    public void setFrom (int val) {
        this.from = val;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.78821AA7-80D7-7B3A-2483-408A7B8B3014]
    // </editor-fold> 
    public int getTo () {
        return to;
    }

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,regenBody=yes,id=DCE.17462858-DC22-277B-65C6-71E6BEF64A2D]
    // </editor-fold> 
    public void setTo (int val) {
        this.to = val;
    }

}
