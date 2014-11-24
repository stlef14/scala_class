import java.awt.Color;



/**
 * @author
 * Class SeamCarver
 */

public class SeamCarver {
    /**
     * BORDER_ENERGY represents the energy on the picture side.
     */
    private static final int BORDER_ENERGY = 195075;
    /**
     * VERTICAL represents the seam carving vertical.
     */
    private static final ModifType VERTICAL = ModifType.VERTICAL;
    /**
     * HORIZ represents the seam carving horizontal.
     */
    private static final ModifType HORIZ = ModifType.HORIZONTAL;
    /**
     * mWidth represents the width of the picture.
     */
    private int mWidth;
    /**
     * mHeight represents the height of the picture.
     */
    private int mHeight;
    /**
     * Picture under analysis.
     */
    private Picture mPicture = null;
    /**
     * The calculated energy array.
     */
    private double[] mEnergy = null;
    /**
     * the connectivity array.
     */
    private int[] mEdgeTo = null;
    /**
     * The accumulated weight to the nodes.
     */
    private double[] mDistanceTo = null;

    /**
     * Getter for private member data.
     * @return mEnergy
     */
    public final double[] getEnergy() {
        return mEnergy;
    }

    /**
     * Setter for data member.
     * @param energy : the energy array for setting the data member.
     */
    public final void setEnergy(final double[] energy) {
        mEnergy = energy;
        return;
    }

    /**
     * @param picture  :  picture to be analyzed with carver
     * Main constructor
     */
    public SeamCarver(final Picture picture) {
        setPicture(picture);
    }

    /**
     * Initializes the picture and it's related arrays like energy, edge, etc..
     * @param pic : The picture to set and initialize
     */
    private void setPicture(final Picture pic) {
        mPicture = pic;
        mWidth = mPicture.width();
        mHeight = mPicture.height();

        mEnergy = new double[mWidth * mHeight];
        mEdgeTo = new int[mWidth * mHeight];
        mDistanceTo = new double[mWidth * mHeight];

        initGradientMatrix();
        initTrackers();
    }

    /**
     * Initializes the trackers.
     */
    private void initTrackers() {
        for (int windex = 0; windex < mWidth; windex++) {
            for (int hindex = 0; hindex < mHeight; hindex++) {
                mEdgeTo[cell(windex, hindex)] = 0;
                mDistanceTo[cell(windex, hindex)] = Double.POSITIVE_INFINITY;
            }
        }
    }

    /**
     * Initializes the initialization of the gradient matrix.
     */
    private void initGradientMatrix() {
        for (int windex = 0; windex < mPicture.width(); windex++) {
            for (int hindex = 0; hindex < mPicture.height(); hindex++) {
                if ((windex == 0) || (hindex == 0)
                   || (windex == (mPicture.width() - 1))
                   || (hindex == (mPicture.height() - 1))) {
                    mEnergy[windex + (hindex * mPicture.width())]
                        = BORDER_ENERGY;
                 } else {
                    mEnergy[cell(windex, hindex)] = getEnergy(windex, hindex);
                 }
            }
         }
    }

    /**
     * Method to calculate and return the cell id, nased on column and row IDs.
     * @param windex : the width index for iterator
     * @param hindex : the height index for iterator
     * @return : the cell id related to the column and the row
     */
    public final int cell(final int windex, final int hindex) {
        return (hindex * mWidth) + windex;
    }

    /**
     * Method for calculating the column id from the cell id.
     * @param cell : return the column Id based on the cell id
     * @return : the column id
     */
    public final int column(final int cell) {
        return column(cell, mWidth);
    }

    /**
     * Method for calculating the column id from cell id and given width.
     * @param cell : cell id
     * @param width : the defined width
     * @return : the column id
     */
    public final int column(final int cell, final int width) {
        return cell % width;
    }

    /**
     * Method for calculating the row id from cell id.
     * @param cell : cell id
     * @return : the row id
     */
    public final int row(final int cell) {
        return row(cell, mWidth);
    }

    /**
     * Method for calculating the row id from cell id and width.
     * @param cell : cell id
     * @param width : the width
     * @return : the row id
     */
    public final int row(final int cell, final int width) {
        return cell / width;
    }

    /**
     * Method for calculating the energy gradient from column and row.
     * @param col : column id
     * @param row : row id
     * @return : the energy gradient
     */
    private double getEnergy(final int col, final int row) {
        Color colxA = mPicture.get(col - 1, row);
        Color colxB = mPicture.get(col + 1, row);
        Color colyA = mPicture.get(col, row - 1);
        Color colyB = mPicture.get(col, row + 1);

        return computeEnergy(colxA, colxB) + computeEnergy(colyA, colyB);
    }

    /**
     * Method for computing the energy.
     * @param cell1 : cell color 1
     * @param cell2 : cell color 2
     * @return : the computed energy
     */
    private double computeEnergy(final Color cell1, final Color cell2) {
        double red = cell1.getRed() - cell2.getRed();
        double blue = cell1.getBlue() - cell2.getBlue();
        double green = cell1.getGreen() - cell2.getGreen();

        return (red * red) + (blue * blue) + (green * green);
    }

    /**
     * Getter method for the picture.
     * @return : the picture
     */
    public final Picture picture() {
        return mPicture;
    } // current picture

    /**
     * Method for accessing the width of the picture.
     * @return : width
     */
    public final int width() {
        if (null != mPicture) {
            return mPicture.width();
        } else {
            return -1;
        }
    } // width of current picture

    /**
     * Method for accessing the height of the picture.
     * @return : height
     */
    public final int height() {
        if (null != mPicture) {
            return mPicture.height();
        } else {
            return -1;
        }
    } // height of current picture

    /**
     * Getter for accessing the energy.
     * @param x : column
     * @param y : row
     * @return : gradient energy
     * @throws IndexOutOfBoundsException : if index is out of bound
     */
    public final double energy(final int x, final int y) {
        if ((x < 0) || (x >= mPicture.width()) || (y < 0)
                || (y >= mPicture.height())) {
            throw new IndexOutOfBoundsException("indexes energy out of bound");
        }

        return mEnergy[cell(x, y)];
    }

    /**
     * @return horizontal seam
     */
    public final int[] findHorizontalSeam() {
        for (int windex = 0; windex < (mWidth - 1); windex++) {
            for (int hindex = 0; hindex < mHeight; hindex++) {
                // if we are on the first row, initialize the distance
                // to the energy
                if (windex == 0) {
                    mDistanceTo[cell(windex, hindex)] = mEnergy[cell(windex,
                            hindex)];
                }

                processHorizontal(windex, hindex);
            }
        }

        int lowestEnergyCell = findLowestEnergyHorizontal();
        int[] seam = new int[mWidth];
        seam[mWidth - 1] = lowestEnergyCell;

        for (int index = mWidth - 2; index >= 0; index--) {
            //trace back the seam
            seam[index] = mEdgeTo[seam[index + 1]];
        }

        return seam;
    }

    /**
     * @return : seam array
     */
    public final int[] findVerticalSeam() {
        for (int hindex = 0; hindex < (mHeight - 1); hindex++) {
            for (int windex = 0; windex < mWidth; windex++) {
                // if we are on the first row, initialize the distance
                // to the energy
                if (hindex == 0) {
                    mDistanceTo[cell(windex, hindex)] = mEnergy[cell(windex,
                            hindex)];
                }

                processVertical(windex, hindex);
            }
        }

        int lowestEnergyCell = findLowestEnergyVertical();
        int[] seam = new int[mHeight];
        seam[mHeight - 1] = lowestEnergyCell;

        for (int index = mHeight - 2; index >= 0; index--) {
            //trace back the seam
            seam[index] = mEdgeTo[seam[index + 1]];
        }

        return seam;
    }

    /**
     * Note of work to complete : Unify the vertical and.
     * horizontal finding lowest energy
     * @return : lowest energy index
     */
    private int findLowestEnergyVertical() {
        // go through last row's distance and find
        // the lowest total energy
        double lowestValue = Double.POSITIVE_INFINITY;
        int lowestIndex = -1;

        for (int windex = 0; windex < mWidth; windex++) {
            if (mDistanceTo[cell(windex, mHeight - 1)] < lowestValue) {
                lowestValue = mDistanceTo[cell(windex, mHeight - 1)];
                lowestIndex = windex;
            }
        }

        return cell(lowestIndex, mHeight - 1);
    }

    /**
     * Method for finding the lowest energy on horizontal.
     * @return : index of lowest energy
     */
    private int findLowestEnergyHorizontal() {
        // go through last row's distance and find
        // the lowest total energy
        double lowestValue = Double.POSITIVE_INFINITY;
        int lowestIndex = -1;

        for (int hindex = 0; hindex < mHeight; hindex++) {
            if (mDistanceTo[cell(mWidth - 1, hindex)] < lowestValue) {
                lowestValue = mDistanceTo[cell(mWidth - 1, hindex)];
                lowestIndex = hindex;
            }
        }

        return cell(mWidth - 1, lowestIndex);
    }

    /**
     * Method for processing vertical calculation.
     * @param col : column id
     * @param row : row id
     */
    private void processVertical(final int col, final int row) {
        // if the column is the first or last, there are only 2 descendants
        relax(cell(col, row), cell(col, row + 1));

        if (col < (mWidth - 1)) {
            relax(cell(col, row), cell(col + 1, row + 1));
        }

        if (col > 0) {
            relax(cell(col, row), cell(col - 1, row + 1));
        }
    }

    /**
     * Method for processing horizontal calculation.
     * @param col : column id
     * @param row : row id
     */
    private void processHorizontal(final int col, final int row) {
        // if the column is the first or last, there are only 2 descendants
        //System.out.println("col="+col+" row="+row);
        relax(cell(col, row), cell(col + 1, row));

        if (row < (mHeight - 1)) {
            relax(cell(col, row), cell(col + 1, row + 1));
        }

        if (row > 0) {
            relax(cell(col, row), cell(col + 1, row - 1));
        }
    }

    /**
     * Relaxation during shortest path calculation.
     * @param cellfrom : cell id of originator
     * @param cellto : cell id of destination
     */
    private void relax(final int cellfrom, final int cellto) {
        if ((mDistanceTo[cellfrom] + mEnergy[cellto]) < mDistanceTo[cellto]) {
            mDistanceTo[cellto] = mDistanceTo[cellfrom] + mEnergy[cellto];
            mEdgeTo[cellto] = cellfrom;
        }
    }

    /**
     * Method removing the horizontal seam.
     * @param seam : seam
     * @throws NullPointerException : null pointer exception
     * @throws IllegalArgumentException : wrong arguments
     */
    public final void removeHorizontalSeam(final int[] seam) {
        removeSeam(seam, SeamCarver.HORIZ);

        return;
    } // remove horizontal seam from current picture

    /**
     * Method removing the vertical seam.
     * @param seam : seam
     * @throws NullPointerException : null pointer
     * @throws IllegalArgumentException : wrong arguments
     */
    public final void removeVerticalSeam(final int[] seam) {
        removeSeam(seam, SeamCarver.VERTICAL);

        return;
    } // remove vertical seam from current picture

    /**
     * Remove the seam.
     * @param seam : seam
     * @param modif : modification vertical vs horizontal
     * @throws NullPointerException
     * @throws IllegalArgumentException
     */
    private void removeSeam(final int[] seam, final ModifType modif) {
        if (null == seam) {
            throw new NullPointerException("null entry");
        }

        int ref;

        if (modif == SeamCarver.VERTICAL) {
            ref = mPicture.height();
        } else {
            ref = mPicture.width();
        }

        if ((seam.length != ref) || (mPicture.height() <= 1)
             || (mPicture.width() <= 1)) {
            throw new IllegalArgumentException(
                "seam different size than picture");
        }

        // check whether the seam is correctly structured
        int previous = colRowRef(seam[0], modif);

        for (int pixvalue : seam) {
            if ((pixvalue < 0)
                   || (pixvalue >= (mPicture.height() * mPicture.width()))
                   || (Math.abs(previous - colRowRef(pixvalue, modif)) > 1)) {
                throw new IllegalArgumentException("invalid seam");
            } else {
                previous = colRowRef(pixvalue, modif);
            }
        }

        setPicture(modifyPicture(mPicture, seam, modif));

        return;
    }

    /**
     * Provide the column and row depending of type.
     * @param cell : cell id
     * @param modif : carving type
     * @return column or row id
     */
    private int colRowRef(final int cell, final ModifType modif) {
        // if modif is VERTICAL it means we are removing the
        // vertical seam, and the reference id desired here is the column
        if (modif == SeamCarver.VERTICAL) {
            return column(cell);
        } else {
            return row(cell);
        }
    }

    /**
     * Modify the picture with the seam.
     * @param aFromPic : picture to modify
     * @param aSeam : seam
     * @param modif : type of modification, vert or horiz
     * @return : modified picture
     */
    public final Picture modifyPicture(final Picture aFromPic,
                      final int[] aSeam, final ModifType modif) {
        int height;
        if (modif == ModifType.HORIZONTAL) {
           height = aFromPic.height() - 1;
        } else {
           height = aFromPic.height();
        }

        int width;
        if (modif == ModifType.VERTICAL) {
            width = aFromPic.width() - 1;
        } else {
            width = aFromPic.width();
        }

        Picture newPic = new Picture(width, height);

        // for horizontal removal, do column by column, for vertical,
        // do row by row
        if (modif == SeamCarver.HORIZ) {
            for (int windex = 0; windex < aFromPic.width(); windex++) {
                for (int hindex = 0, newp = 0; hindex < aFromPic.height();
                        hindex++) {
                    int cellid = cell(windex, hindex);

                    if (cellid != aSeam[windex]) {
                        newPic.set(windex, newp++,
                                   aFromPic.get(windex, hindex));
                    }
                }
            }
        } else {
            for (int hindex = 0; hindex < aFromPic.height(); hindex++) {
                for (int windex = 0, newp = 0; windex < aFromPic.width();
                        windex++) {
                    int cellid = cell(windex, hindex);

                    if (cellid != aSeam[hindex]) {
                        newPic.set(newp++, hindex,
                                   aFromPic.get(windex, hindex));
                    }
                }
            }
        }

        return newPic;
    }

    /**
     * @param args : arguments
     */
    public static void main(final String[] args) {
        System.out.println("Loading picture " + args[0] + " ...");
        final int aNumIter = 135;

        Picture aPictureMock = new Picture(args[0]);
        SeamCarver sc = new SeamCarver(aPictureMock);
        aPictureMock.show();

        for (int index = 0; index < aNumIter; index++) {
            int[] list = sc.findVerticalSeam();
            //int[] list=sc.findHorizontalSeam();
            sc.removeVerticalSeam(list);

            //sc.removeHorizontalSeam(list);
        }

        sc.mPicture.show();
    }
    /**
     * Type of modification.
     * @param VERTICAL : vertical
     * @param HORIZONTAL : horizontal
     *
     */
    enum ModifType { VERTICAL,
        /**
         * Horizontal constant.
         */
        HORIZONTAL
    };
}
